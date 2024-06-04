package lab7.products;

public class Magazine extends Edition{


    private String issueNumber;

    public String getIssueNumber() {
        return issueNumber;
    }

    public Magazine() {}

    public Magazine(String title, double price, Genre genre, int year,String issueNumber)
            throws Exception {
        super(title, price, genre, year);
        if (issueNumber == "") {
            throw new Exception("Invalid issue format");
        }
        this.issueNumber = issueNumber;


    }


    @Override
    public String toString() {
        return "Magazine{" +
                "issueNumber='" + issueNumber + '\'' +
                '}';
    }
}
