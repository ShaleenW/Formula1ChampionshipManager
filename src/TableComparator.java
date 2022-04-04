import java.util.Comparator;

public class TableComparator implements Comparator<Formula1Driver> { //comparator to sort the Championship table

    @Override
    public int compare(Formula1Driver d1, Formula1Driver d2) {
        if (d1.getTotalPoints() > d2.getTotalPoints())
            return -1;
        else
        if (d2.getTotalPoints() > d1.getTotalPoints())
            return 1;
        else {
            int fistPosDif1 = d1.getTotalFirstPositions()- d2.getTotalFirstPositions();
            int fistPosDif2 = d2.getTotalFirstPositions()-d1.getTotalFirstPositions();
            if (fistPosDif1 > fistPosDif2)
                return -1;
            else
            if (fistPosDif1 < fistPosDif2)
                return 1;
            else return 0;
        }
    }
}
