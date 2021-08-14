class ArmstrongNumbers {
    boolean isArmstrongNumber(int num) {
        String str = Integer.toString(num);

        int deg = str.length();

        if (deg > 1) {
            int sum = 0;

            for (int i = 0; i < deg; i++) {
                sum += (int) Math.pow(Character.getNumericValue(str.charAt(i)), deg);
            }

            return num == sum;
        }

        return true;
    }
}
