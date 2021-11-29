/*   Class to implement String encrytion and decryption		*/
public class CipherDecipher {

	public static void main(String args[]) {
		String normal = "Welcome to hackerrank";
		String ciphered = "?85O89*69R65*87O104*33I1043";
		System.out.println(ciphering(normal));
		System.out.println(deciphering(ciphered));

		System.out.println(filter());
}

	private static String deciphering(String ciphered) {
		ciphered = ciphered.trim().replaceAll("\\*", "\s");
		String result = "";
		String temp = "";
		for (int i = 0; i < ciphered.length() - 1; i++) {
			if (ciphered.charAt(i) >= '0' && ciphered.charAt(i) <= '9')
				temp += ciphered.charAt(i);
			else {
				if (temp != "")
					result += (char) Integer.parseInt(temp);
				result += ciphered.charAt(i);
				temp = "";
			}
		}
		result += (char) Integer.parseInt(temp);
		StringBuffer sb = new StringBuffer(result).reverse();
		result = "";
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) >= 65 && sb.charAt(i) <= 90)
				result += (char) (sb.charAt(i) + 32);
			else if (sb.charAt(i) >= 90 && sb.charAt(i) <= 122)
				result += (char) (sb.charAt(i) - 32);
			else
				result += sb.charAt(i);
		}
		return result;

	}

	private static String ciphering(String normal) {
		StringBuffer sb = new StringBuffer(normal.trim().replaceAll(" ", "*")).reverse();
		String result = "";
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) >= 65 && sb.charAt(i) <= 90) {
				if (i % 2 == 1)
					result += (int) (sb.charAt(i) + 32);
				else
					result += (char) (sb.charAt(i) + 32);
			} else if (sb.charAt(i) >= 90 && sb.charAt(i) <= 122) {
				if (i % 2 == 1)
					result += (int) (sb.charAt(i) - 32);
				else
					result += (char) (sb.charAt(i) - 32);
			} else
				result += sb.charAt(i);
		}
		return result + "3";
	}
	
	public static String filter()
    {
        String happyNumbers="";
        loop1:
        for(int i=1;i<=150;i++)
        {
            int temp=i;
            int sum=0;
            while(true)
            {
                while(temp>0)
                {
                    int rem=temp%10;
                    sum+=rem*rem;
                    temp=temp/10;
                }
                if(sum==1)
                {
                    happyNumbers+=i+" ";
                    continue loop1;
                }
                else if(sum==4)
                {
                    continue loop1;
                }
                temp=sum;
                sum=0;
            }
        }
        return happyNumbers.trim();
    }

}
