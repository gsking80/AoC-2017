package king.greg.advent_2017;

public class Day11 {

    int nw_se = 0;
    int n_s = 0;
    int ne_sw = 0;

    int farthest = 0;

    public void track (final String path) {

        final String[] steps = path.split(",");
        for (final String step: steps) {
            switch(step) {
                case "nw":
                    nw_se++;
                    break;
                case "n":
                    n_s++;
                    break;
                case "ne":
                    ne_sw++;
                    break;
                case "se":
                    nw_se--;
                    break;
                case "s":
                    n_s--;
                    break;
                case "sw":
                    ne_sw--;
                    break;
            }
            collapse();
            if (minimumSteps() > farthest) {
                farthest = minimumSteps();
            }
        }

    }

    public int minimumSteps() {
        //first collapse steps
        return Math.abs(nw_se) + Math.abs(n_s) + Math.abs(ne_sw);
    }

    public int getFarthest() {
        return farthest;
    }

    private void collapse() {
        while (nw_se > 0 && ne_sw > 0) {
            nw_se--;
            ne_sw--;
            n_s++;
        }
        while (n_s > 0 && nw_se < 0) {
            n_s--;
            nw_se++;
            ne_sw++;
        }
        while (ne_sw > 0 && n_s < 0) {
            ne_sw--;
            n_s++;
            nw_se--;
        }
        while (nw_se < 0 && ne_sw < 0) {
            nw_se++;
            ne_sw++;
            n_s--;
        }
        while (n_s < 0 && nw_se > 0) {
            n_s++;
            nw_se--;
            ne_sw--;
        }
        while (ne_sw < 0 && n_s > 0) {
            ne_sw++;
            n_s--;
            nw_se++;
        }
    }

}
