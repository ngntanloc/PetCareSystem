/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author Nguyen Tan Loc
 */
public class MyToys {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String ingputMsg, String errorMsg) {
        String s;
        while (true) {
            try {
                System.out.println(ingputMsg);
                s = sc.nextLine();
                if (s.isEmpty() || s.isBlank()) {
                    throw new Exception();
                } else {
                    return s;
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound) {
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n;
        while (true) {
            try {
                System.out.println(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getGender(String inputMsg, String errorMsg) {
        String s;
        while (true) {
            try {
                System.out.println(inputMsg);
                s = sc.nextLine().trim().toUpperCase();
                if (s.equalsIgnoreCase("BOY")) {
                    return s;
                } else if (s.equalsIgnoreCase("GIRL")) {
                    return s;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        double a;
        if (lowerBound > upperBound) {
            int tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.println(inputMsg);
                a = Double.parseDouble(sc.nextLine());
                if (a < lowerBound || a > upperBound) {
                    throw new Exception();
                }
                return a;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg, String format) {
        String s;
        boolean match;
        while (true) {
            try {
                System.out.println(inputMsg);
                s = sc.nextLine().trim().toUpperCase();
                match = s.matches(format);
                if (s.isEmpty() || s.isBlank() || match == false) {
                    throw new Exception();
                }
                return s;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getDay(String msg) {
        String bday;
        String regex = ("^(((0[1-9]|[12]\\d|3[01])\\/(0[13578]|1[02])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|[12]\\d|30)\\/(0[13456789]|1[012])\\/((19|[2-9]\\d)\\d{2}))|((0[1-9]|1\\d|2[0-8])\\/02\\/((19|[2-9]\\d)\\d{2}))|(29\\/02\\/((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))))$");
        while (true) {
            try {
                sc = new Scanner(System.in);
                System.out.println(msg);
                bday = sc.nextLine();
                if (!bday.matches(regex) || bday.isEmpty() || bday.isBlank()) {
                    throw new Exception("PLEASE INPUT dd/mm/yyyy or dd-mm-yyyy");
                } else {
                    return bday;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
