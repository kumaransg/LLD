package one;

public class sum {

    public static void main(String args[]){

        int sum = calculateSum(1,3);
        System.out.println(1010);
        System.out.println(9%10);
    }

    public static int calculateSum(int a, int b){
        int c = a^b;
        int d = (a&b)<<1;
        return b == 0 ? a : calculateSum(a ^ b, (a & b) << 1);

//        const Sum=a^b;              // sum = a xor b = a ⊕ b
//        const carry=(a&b)<<1;       // carry = 2*(a and b), since we carry to the next bit
//        if(!carry){
//            return Sum;             // no carry, so sum + carry = sum
//        }
//        return getSum(Sum,carry);
    }
//
//    Let's learn by example. Imagine that a = 3 and b = 5
//
//    In binary notation they are a = 0011 and b = 0101
//
//    XOR: a^b is XOR operator. When compare two bits it returns 0 if they are same and 1 if they are different. 01^10 => 11
//
//    So when we're doing a^b result will be 0110.
//
//    AND + SHIFT
//
//    a&b performs logical AND operation. It returns 1 only when a = b = 1.
//
//    In our case the result is 0001
//
//            << shifts it(adds 0 on the right side) and result became 0010 which sets carry variable true. (only 0000 will be false).
//
//    Next iterations:
//
//    Everything repeats but now a = 0110 and b = 0010 (Sum and carry from last execution)
//
//    Now a^b = 0100 and (a&b)<<1 = 0100
//
//    Repeating again.
//
//    Now a^b = 0000 and (a&b)<<1 = 1000
//
//    And again.
//
//    Now a^b = 1000 and (a&b)<<1 = 0000. Now carry is finally false. And we're returning 1000 which is decimal 8.
//
////    Everything worked fine since 3+5=8
//
//            ╔═══════╤═════════════╗
//            ║ Input │   Output    ║
//            ╠═══╤═══╪═══════╤═════╣
//            ║ A │ B │ carry │ sum ║
//            ╟───┼───┼───────┼─────╢
//            ║ 0 │ 0 │   0   │  0  ║
//            ╟───┼───┼───────┼─────╢
//            ║ 1 │ 0 │   0   │  1  ║
//            ╟───┼───┼───────┼─────╢
//            ║ 0 │ 1 │   0   │  1  ║
//            ╟───┼───┼───────┼─────╢
//            ║ 1 │ 1 │   1   │  0  ║
//            ╚═══╧═══╧═══════╧═════╝
}
