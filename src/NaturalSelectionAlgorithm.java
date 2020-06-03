import java.util.ArrayList;

public class NaturalSelectionAlgorithm {
    public static ArrayList<Integer> currentGeneration = new ArrayList<>();
    public static ArrayList<Integer> successorGeneration = new ArrayList<>();

    public NaturalSelectionAlgorithm(){
    }

    private static Integer verifyDeadCell(int neighbors){
        if(neighbors == 3){
            return 0;
        }
        return 1;
    }

    private static Integer verifyAliveCell(int neighbors){
        if(neighbors == 2 || neighbors == 3) {
            return 0;
        }
        return 1;
    }

    public static ArrayList<Integer> getNextGeneration(ArrayList<Integer> currentGeneration){
        ArrayList<Integer> successorGeneration = new ArrayList<>();

        int length = (int) Math.sqrt(Double.parseDouble(Integer.toString(currentGeneration.size())));
        for (int i=0; i<currentGeneration.size(); i++) {
            int neighbors = 0;
            //if cell is alive
            if (currentGeneration.get(i) == 0) {
                //topLeft
                try{
                    if (currentGeneration.get(i - length - 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //top
                try{
                    if (currentGeneration.get(i - length) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //top right
                try{
                    if (currentGeneration.get(i - length + 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //left
                try{
                    if (currentGeneration.get(i - 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //right
                try{
                    if (currentGeneration.get(i + 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //bottom left
                try{
                    if (currentGeneration.get(i + length - 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //bottom
                try{
                    if (currentGeneration.get(i + length) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //bottom right
                try{
                    if (currentGeneration.get(i + length + 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                successorGeneration.add(verifyAliveCell(neighbors));
            }
            //cell is dead
            else{
                //topLeft
                try{
                    if (currentGeneration.get(i - length - 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //top
                try{
                    if (currentGeneration.get(i - length) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //top right
                try{
                    if (currentGeneration.get(i - length + 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //left
                try{
                    if (currentGeneration.get(i - 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //right
                try{
                    if (currentGeneration.get(i + 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //bottom left
                try{
                    if (currentGeneration.get(i + length - 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //bottom
                try{
                    if (currentGeneration.get(i + length) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                //bottom right
                try{
                    if (currentGeneration.get(i + length + 1) == 0) {
                        neighbors++;
                    }
                }
                catch (IndexOutOfBoundsException e){
                }
                successorGeneration.add(verifyDeadCell(neighbors));
            }
        }

        return successorGeneration;
    }

}
