// Hanoi Tower game

package java_class.Seminar2;

public class hanoi_app {

    static void hanoi_tower(int n, char pole_one, char pole_two, char helper_pole){
        if (n == 1){
            System.out.println("Move disk 1 from pole " + pole_one + " to pole " + pole_two);
            return;
        }
        hanoi_tower(n-1, pole_one, helper_pole, pole_two);
        System.out.println("Move disk " + n + " from pole " + pole_one + " to pole " + pole_two);
        hanoi_tower(n-1, helper_pole,  pole_two, pole_one);
    }
    public static void main(String[] args) {
        int n = 3;
        hanoi_tower(n, 'A', 'C', 'B');
    }
}