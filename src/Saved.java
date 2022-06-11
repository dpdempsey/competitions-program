public class Saved {
    /*     public void loadFile(){
        System.out.println("File name:");
        String fileName = kb.nextLine();
        this.fileName = fileName;

        System.out.println("Member file:");
        String memberFile = kb.nextLine();
        this.memberFile = memberFile;

        System.out.println("Bill file:");
        String billFile = kb.nextLine();
        this.billFile = billFile;
    }

    public void noFileTesting(){
        System.out.println("Member file:");
        String memberFile = kb.nextLine();
        this.memberFile = memberFile;

        System.out.println("Bill file:");
        String billFile = kb.nextLine();
        this.billFile = billFile;
    }

    public String getFileName(){
        return this.fileName;
    } */


/*     public void addNewEntry() {
        boolean thing = true;
        while (thing) {
            System.out.println("Bill ID:");
            String billID = kb.nextLine();
            if (billID.matches("[0-9]+") && billID.length() == 6) {
                Bill bill = new Bill();
                ArrayList<Bill> bills = bill.getBills();
                for (Bill b : bills) {
                    if ((b.getBillId()).equals(billID)) {
                        if ((b.getMemberId()).equals(" ")) {
                            System.out.println("This bill has no member id. Please try again.");
                        } else {
                            System.out.println("This bill ($" + b.getBillAmount() + ") is eligible for " + b.getEntries() + "entries. How many manual entries did the customer fill up?:");
                            //return b;
                        }
                    }
                }
            } else {
                System.out.println("Invalid bill id! It must be a 6-digit number. Please try again.");
            }
        }
    } */

/*     public Bill iterate(String billID) {
        for (Bill bill : bills) {
            if ((bill.getBillId()).equals(billID)) {
                if ((bill.getMemberId()).equals(" ")) {
                    System.out.println("This bill has no member id. Please try again.");
                } else {
                    return bill;
                }
            }
        }
        return null;
    } */
}
