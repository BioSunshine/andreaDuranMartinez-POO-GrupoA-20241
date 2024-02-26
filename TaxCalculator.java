public class TaxCalculator {
    public String calculateTaxes(int income){
        double total = income +0.15;
        return String.format("The total taxes is: %.3f", total);
    }

    public String calculateTaxes(double sales, double taxPercentage){
        double total = sales*(taxPercentage/100);
        return String.format("The total taxes is: %.3f", total);
    }

    public String calculateTaxes(double dividends, double taxPercentage, double excemption){
        double total = dividends*(taxPercentage/100);

        if(total>excemption) {
            total = total-excemption;
        }
        else{ total=0;
        }
        return String.format("The total taxes is: %.3f", total);
    }
}
