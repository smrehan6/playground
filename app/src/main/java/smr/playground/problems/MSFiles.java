package smr.playground.problems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 715K 2009-09-23 system.zip~
 179K 2013-08-14 to-do-list.xml~
 645K 2013-06-19 blockbuster.mpeg~
  536 2010-12-12 notes.html
 688M 1990-02-11 delete-this.zip~
  23K 1987-05-24 setup.png~
 616M 1965-06-06 important.html
  14M 1992-05-31 crucial-module.java~
 192K 1990-01-31 very-long-filename.dll~
* */

/*
 * MS Problem 2
 * */
public class MSFiles {

    private static final char TICK = '\u2713';
    private static final char CROSS = '\u2717';
    private static final String INPUT =
            " 715K 2009-09-23 system.zip~\n" +
            " 179K 2013-08-14 to-do-list.xml~\n" +
            " 645K 2013-06-19 blockbuster.mpeg~\n" +
            "  536 2010-12-12 notes.html\n" +
            " 688M 1990-02-11 delete-this.zip~\n" +
            "  23K 1987-05-24 setup.png~\n" +
            " 616M 1965-06-06 important.html\n" +
            "  14M 1992-05-31 crucial-module.java~\n" +
            " 192K 1990-01-31 very-long-filename.dll~";


    public static void main(String[] args) {
        System.out.println(solution(INPUT));
    }

    private static final String NO_FILES = "NO FILES";
    private static final int MAX_SIZE = (int) (14 * Math.pow(2, 20)); // 14MB
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final String minDateStr = "1990-01-31";

    public static String solution(String S) {
        // write your code in Java SE 8
        String[] rows = S.split("\n");
        int count = 0;
        for (String row : rows) {
            MyFile file = new MyFile(row.trim());
            System.out.print(row);
            if (file.check()) {
                count++;
                System.out.println(" " + TICK);
            } else {
                System.out.println(" " + CROSS);
                System.out.println(file.reason);
            }
        }
        if (count > 0) {
            return String.valueOf(count);
        } else {
            return NO_FILES;
        }
    }

    static int getSize(String s) {
        int size;
        try {
            size = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            int lastIndex = s.length() - 1;
            size = Integer.parseInt(s.substring(0, lastIndex));
            char ch = s.charAt(lastIndex);
            int pow;
            switch (ch) {
                case 'G':
                    pow = 3;
                    break;
                case 'M':
                    pow = 2;
                    break;
                case 'K':
                    pow = 1;
                    break;
                default:
                    pow = 0;
            }
            size = size * (int) Math.pow(1024, pow);
        }
        return size;
    }

    static class MyFile {

        private static final Date MIN_DATE;

        static {
            try {
                MIN_DATE = sdf.parse(minDateStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid min date");
            }
        }

        String filename;
        String sizeStr;
        String dateStr;
        String reason;

        boolean isBackupFile;
        int size;
        Date lastModified;

        MyFile(String row) {
            String[] cols = row.split(" ");
            sizeStr = cols[0];
            dateStr = cols[1];
            filename = cols[2];
            isBackupFile = filename.endsWith("~");
            try {
                lastModified = sdf.parse(dateStr);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid date");
            }

            size = getSize(sizeStr);
        }

        boolean check() {
            boolean result = true;
            StringBuilder sb = new StringBuilder();
            if (!isBackupFile) {
                sb.append(" FILENAME");
                result = false;
            }
            if (lastModified.before(MIN_DATE)) {
                sb.append(" DATE");
                result = false;
            }
            if (size > MAX_SIZE) {
                sb.append(" SIZE");
                result = false;
            }
            reason = sb.toString();
            return result;
        }

        @Override
        public String toString() {
            return size + ":" + sdf.format(lastModified) + ":" + isBackupFile;
        }
    }
}
