package Backend.User;

import java.util.ArrayList;
import java.util.List;

public class AMS extends Cadeira{
    private List<Double> test_marks = new ArrayList<Double>();
    private List<Double> test_weight = new ArrayList<Double>();
    private List<Double> project_marks = new ArrayList<Double>();
    private List<Double> project_weight = new ArrayList<Double>();

    private Double practic_weight = 0.5;
    private Double teorical_weight = 0.5;

    public AMS(){
        super("AMS", 6.0);
    }

    public Double calculateMark(){
        Double pratical = 0.0, teorical = 0.0;
        for(int i = 0; i < test_marks.size(); i++){
            teorical += test_marks.get(i)*test_weight.get(i);
        }

        for(int i = 0; i < project_marks.size(); i++){
            pratical += project_marks.get(i)*project_weight.get(i);
        }

        return teorical*teorical_weight + pratical*practic_weight;
    }
    
}
