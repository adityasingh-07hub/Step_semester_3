import java.util.Arrays;

public class Top3Finder {
    public static void main(String[] args) {

        int[] scores  = {45, 82, 79, 90, 33, 99, 61};
        int[] result = topThree(scores );
        System.out.println(Arrays.toString(result));
    }

    private static int[] topThree(int[] scores){
        int first = 0;
        int second = 0;
        int third = 0;

        for(int score : scores){   //first = 0, second = 0, third = 0    //{45, 82, 79, 90, 33, 90, 61}

                                    //ITERATION 1   ||    ITERATION 2     ||  ITERATION 3     ||    ITERATION 4   ||   ITERATION 5    ||   ITERATION 6     ||   ITERATION 7
                                  //score = 45      ||    score = 82      ||   score = 79     ||   score = 90     ||   score = 33     ||   score = 90      ||   score = 61
            //--------------------------------------------------------------------------------------------------------------------------------------------
            if(score>=first){     //45>=0 -> true   ||    82>=45 -> true  ||79>=82 -> false   ||90>=82 -> true    ||33>=90 -> false   ||90>=90 -> true     ||61>=90 -> false
                third = second;   //third = 0       ||    third = 0       ||                  ||third = 79        ||                  ||third = 82         ||
                second = first;   //second = 0      ||    second = 45     ||                  ||second = 82       ||                  ||second = 90        ||
                first = score;    //first = 45      ||    first = 82      ||                  ||first = 90        ||                  ||first = 90         ||
            }
            else if(score>=second){ //              ||                    ||79>=45 -> true    ||                  ||33>=82 -> false   ||                   ||61>=90 -> false
                third = second;     //              ||                    ||third = 45        ||                  ||                  ||                   ||
                second = score;     //              ||                    ||second = 79       ||                  ||                  ||                   ||
            }
            else if (score >= third){ //            ||                    ||                  ||                  ||33>=79 -> false   ||                   ||
                third = score;        //            ||                    ||                  ||                  ||                  ||                   ||
            }
        }
        return new int[]{first,second,third};
    }
}