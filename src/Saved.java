public class Saved {
    /*
     * public void loadFile(){
     * System.out.println("File name:");
     * String fileName = kb.nextLine();
     * this.fileName = fileName;
     * 
     * System.out.println("Member file:");
     * String memberFile = kb.nextLine();
     * this.memberFile = memberFile;
     * 
     * System.out.println("Bill file:");
     * String billFile = kb.nextLine();
     * this.billFile = billFile;
     * }
     * 
     * public void noFileTesting(){
     * System.out.println("Member file:");
     * String memberFile = kb.nextLine();
     * this.memberFile = memberFile;
     * 
     * System.out.println("Bill file:");
     * String billFile = kb.nextLine();
     * this.billFile = billFile;
     * }
     * 
     * public String getFileName(){
     * return this.fileName;
     * }
     */

    /*
     * public void addNewEntry() {
     * boolean thing = true;
     * while (thing) {
     * System.out.println("Bill ID:");
     * String billID = kb.nextLine();
     * if (billID.matches("[0-9]+") && billID.length() == 6) {
     * Bill bill = new Bill();
     * ArrayList<Bill> bills = bill.getBills();
     * for (Bill b : bills) {
     * if ((b.getBillId()).equals(billID)) {
     * if ((b.getMemberId()).equals(" ")) {
     * System.out.println("This bill has no member id. Please try again.");
     * } else {
     * System.out.println("This bill ($" + b.getBillAmount() + ") is eligible for "
     * + b.getEntries() +
     * "entries. How many manual entries did the customer fill up?:");
     * //return b;
     * }
     * }
     * }
     * } else {
     * System.out.
     * println("Invalid bill id! It must be a 6-digit number. Please try again.");
     * }
     * }
     * }
     */

    /*
     * public Bill iterate(String billID) {
     * for (Bill bill : bills) {
     * if ((bill.getBillId()).equals(billID)) {
     * if ((bill.getMemberId()).equals(" ")) {
     * System.out.println("This bill has no member id. Please try again.");
     * } else {
     * return bill;
     * }
     * }
     * }
     * return null;
     * }
     */

    /*
     * System.out.println("Add more entries (Y/N)?");
     * line = SimpleCompetitions.kb.nextLine();
     * if(line.equals("Y")){
     * //continue;
     * } else {
     * temp = false;
     * }
     */

    /*
     * manualEntries();
     * NumbersEntry numEnt = new NumbersEntry();
     * AutoNumbersEntry autoNumEnt = new AutoNumbersEntry();
     * autoNumEnt.createNumbers(1);
     * 
     * public int[] manualEntries() {
     * boolean temp2 = true;
     * while(temp2){
     * System.out.
     * println("Please enter 7 different numbers (from the range 1 to 35) separated by whitespace."
     * );
     * String line = SimpleCompetitions.kb.nextLine();
     * String parts[] = line.split(" ");
     * int[] intArray = new int[parts.length];
     * for(int i=0; i<parts.length; i++){
     * intArray[i] = Integer.parseInt(parts[i]);
     * }
     * if(intArray.length < 7){
     * System.out.
     * println("Invalid input! Fewer than 7 numbers are provided. Please try again!"
     * );
     * } else if(intArray.length > 7){
     * System.out.
     * println("Invalid input! More than 7 numbers are provided. Please try again!"
     * );
     * } else if(!this.checkMax(intArray)){
     * System.out.
     * println("Invalid input! All numbers must be in the range from 1 to 35!");
     * } else if(!this.checkDuplicate(intArray)){
     * System.out.println("Invalid input! All numbers must be different!");
     * } else {
     * Arrays.sort(intArray);
     * return intArray;
     * }
     * }
     * return null;
     * }
     * 
     */

    /*
     * public Competition addNewCompetition(String choice, String compName) {
     * 
     * if (choice.equals("R")) {
     * RandomPickCompetition ranComp = new RandomPickCompetition(compName);
     * this.competition = ranComp;
     * System.out.println("A new competition has been created!");
     * System.out.println(ranComp.info());
     * return ranComp;
     * } else if (choice.equals("L")) {
     * LuckyNumbersCompetition luckComp = new LuckyNumbersCompetition(compName);
     * System.out.println("A new competition has been created!");
     * System.out.println(luckComp.info());
     * this.competition = luckComp;
     * return luckComp;
     * } else {
     * return null;
     * }
     * }
     */

    /*
     * public int[] manualEntries() {
     * boolean temp2 = true;
     * while (temp2) {
     * System.out.
     * println("Please enter 7 different numbers (from the range 1 to 35) separated by whitespace."
     * );
     * String line = SimpleCompetitions.kb.nextLine();
     * String parts[] = line.split(" ");
     * int[] intArray = new int[parts.length];
     * for (int i = 0; i < parts.length; i++) {
     * intArray[i] = Integer.parseInt(parts[i]);
     * }
     * if (intArray.length < 7) {
     * System.out.
     * println("Invalid input! Fewer than 7 numbers are provided. Please try again!"
     * );
     * } else if (intArray.length > 7) {
     * System.out.
     * println("Invalid input! More than 7 numbers are provided. Please try again!"
     * );
     * } else if (!this.checkMax(intArray)) {
     * System.out.
     * println("Invalid input! All numbers must be in the range from 1 to 35!");
     * } else if (!this.checkDuplicate(intArray)) {
     * System.out.println("Invalid input! All numbers must be different!");
     * } else {
     * Arrays.sort(intArray);
     * return intArray;
     * }
     * }
     * return null;
     * }
     */
}
