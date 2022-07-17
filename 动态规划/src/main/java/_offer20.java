public class _offer20 {
    public static void main(String[] args) {
        String s = "-1E-16";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        String str = s.trim();
        if(str.length()==0)return false;
        if (str.startsWith("+") || str.startsWith("-") || str.startsWith(".") || ('0' <= str.charAt(0) && '9' >= str.charAt(0))) {
            if (str.startsWith("+") || str.startsWith("-")) {
                String removed = str.substring(1);
                return isInteger(removed) || isDecimal(removed);
            } else {
                return isInteger(str) || isDecimal(str);
            }
        }
        return false;
    }

    private static boolean isDecimal(String s) {
        if (s.startsWith(".")) {
            try {
                Integer.valueOf(s.substring(1));
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else if (s.endsWith(".")) {
            try {
                Integer.valueOf(s.substring(0, s.length() - 1));
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            String[] split = s.split("\\.");
            if (split.length == 0) return false;
            try {
                Integer.valueOf(split[0]);
                Integer.valueOf(split[1]);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }

    public static boolean isInteger(String s) {
        boolean flag1, flag2;
        try {
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e) {
            try {
                String[] es = s.split("e");
                if (es.length != 2) {
                    String[] Es = s.split("E");
                    if(Es.length!=2) return false;
                    for (String ss : Es) {
                        Integer.valueOf(ss);
                    }
                    flag2 = true;
                    if (flag2) return true;
                } else {
                    for (String ss : es) {
                        Integer.valueOf(ss);
                    }
                    flag1 = true;
                    if (flag1) return true;
                }
            } catch (NumberFormatException ex) {
                try {
                    String[] Es = s.split("E");
                    if (Es.length != 2) {
                        return false;
                    } else {
                        for (String ss : Es) {
                            Integer.valueOf(ss);
                        }
                        flag2 = true;
                        if (flag2) return true;
                    }
                } catch (NumberFormatException exc) {
                    return false;
                }
            }
        }
        return true;
    }
}
