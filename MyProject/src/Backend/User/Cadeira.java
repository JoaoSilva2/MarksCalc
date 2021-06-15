package Backend.User;

abstract class Cadeira {
    private String _name;
    private Double _final_mark;
    private Double _ects;

    Cadeira(String name, Double ects){
        _name = name;
        _ects = ects;
    }

    public abstract Double calculateMark();

    public String getName(){
        return _name;
    }

    public Double acceptAverage(){
        return _ects*_final_mark;
    }


}
