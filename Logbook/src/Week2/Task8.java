package Week2;

public class Task8 {
    public static void main(String[] args)
    {
        int currentCounter = 0;

        while (currentCounter < 9) {
            for (int x = 0; x < 11; x++) {
                if (x % 2 == 0) System.out.println(x);
            }

            currentCounter += 1;
        }
    }
}
