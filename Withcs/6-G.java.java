/*DESCRIPTION
신용카드 번호는 일정한 규칙을 가지고 있습니다. 신용카드 번호는 13~16개의 숫자로 되어 있고, 카드 회사에 따라 다음과 같은 숫자로 시작합니다.

Credit card numbers follow certain patterns. A credit card number must have between 13 and 16 digits. It must start with:

■ 4 for Visa cards
■ 5 for Master cards
■ 37 for American Express cards
■ 6 for Discover cards

1954년 IBM의 Hans Luhn는 신용카드 번호가 타당한지 체크하는 알고리즘을 제안하였습니다. 그 알고리즘은 카드번호가 올바르게 입력되었는지 체크하거나 카드리더기가 번호를 올바르게 인식했는지 체크하는 용도로 유용히 사용되어 왔습니다. Luhn check 또는 Mod 10 check로 알려진 체크 알고리즘은 다음과 같습니다. (설명을 위해 카드번호는 4388576018402626로 간주):

In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card numbers. The algorithm is useful to determine whether a card number is entered correctly or whether a credit card is scanned correctly by a scanner. Credit card numbers are generated following this validity check, commonly known as the Luhn check or the Mod 10 check, which can be described as follows (for illustration, consider the card number 4388576018402626):

1. 오른쪽에서 왼쪽으로 짝수위치의 숫자들을 각각 두배합니다. 만약 두배된 숫자가 10이상이면 십의 자리와 일의 자리의 숫자를 더해서 한자리 숫자로 만듭니다. (Double every second digit from right to left. If doubling of a digit results in a two-digit number, add up the two digits to get a single-digit number)



2. 단계1에서 구한 모든 숫자를 더합니다. (Now add all single-digit numbers from Step 1)

4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37

3. 오른쪽에서 왼쪽으로 홀수 위치의 숫자들을 모두 더합니다. (Add all digits in the odd places from right to left in the card number.)

6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38

4. 단계2와 단계3에서 구한 숫자를 더합니다. (Sum the results from Step 2 and Step 3.)

37 + 38 = 75

5. 단계4에서 구한 숫자가 10으로 나누어 떨어지면, 카드번호는 타당합니다. 예를 들어, 4388576018402626 번호는 신용카드 번호로써 타당하지 않지만 4388576018410707는 타당한 신용카드 번호 입니다. (If the result from Step 4 is divisible by 10, the card number is valid; otherwise, it is invalid. For example, the number 4388576018402626 is invalid, but the number 4388576018410707 is valid.)

신용카드 번호를 입력 받아서 타당하다면 Valid를 타당하지 않다면 Invalid를 출력하는 프로그램을 작성하세요. (long integer로 입력받아야 오류를 피할 수 있을 것입니다)

Write a program that prompts the user to enter a credit card number as a long integer. Display whether the number is valid or invalid. 

 

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 신용번호 (13~16자리 정수)

 

OUTPUT
* Line 1 ~ T : 타당한 신용카드 번호면 Valid를 그렇지 않다면 Invalid를 출력

 

SAMPLE INPUT
2
4388576018410707
4388576018402626
SAMPLE OUTPUT
Valid
Invalid
SOURCE
JAVA2015 PE6.31
*/

import java.util.*;
public class Main {
    static Scanner scan = new Scanner(System.in);
    
    
    
    public static void main(String[] args) {
        String p= scan.nextLine();
        
        int p1=Integer.parseInt(p);
        
        
        int[] l=new int[p1];
        
        
        String[] s=new String[p1];
        
        
        for (int i=0;i<p1;i++) {
            s[i]= scan.nextLine();
        }
        for (int i=0;i<p1;i++) {
            if (gilyi(s[i])==0 &&
                    duhae(s[i])==0 && shijak(s[i])==0) {
                
                System.out.println("Valid");
            }
            else
                System.out.println("Invalid");
        }
    }
    
    static public int shijak(String x) {
        char x1=x.charAt(0);
        char y1=x.charAt(1);

        
        
        if (x1=='4' || x1=='5' || x1=='6')
            return 0;
        else if (x1=='3' && y1=='7')
            return 0;
        else
            return 1;
    }
    
    
    
    
    
    static public int gilyi(String x) {
        int x1=x.length();
        if (x1>=13 && x1<=16)
            return 0;
        return 1;
    }
    
    static public int duhae(String x) {
        int p1=0;
        int p2=0;

        
        
        for (int i=x.length()-2;i>=0;i=i-2) {
            char c=x.charAt(i);
            
            
            String a=Character.toString(c);
            int b=Integer.parseInt(a);
            b*=2;
            if (b>=10) {
                p1+=b%10+b/10;
            }
            else {
                p1 += b;
            }
        }
        
        
        
        
        
        
        for (int i=x.length()-1;i>=0;i=i-2) {
            char z=x.charAt(i);
            String a=Character.toString(z);
            int b=Integer.parseInt(a);
            p2+=b;
        }
        
        
        
        if ((p1+p2)%10==0)
            return 0;
        else
            return 1;
    }
}
