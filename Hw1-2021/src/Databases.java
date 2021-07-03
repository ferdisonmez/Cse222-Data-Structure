public class Databases {
    private int Officechairsize;
    private int Officedesksize;
    private int Meetingtablesize;
    private int Bookcasesize;
    private int Officecabinet;

    public Databases(int officechairsize, int officedesksize, int meetingtablesize, int bookcasesize, int officecabinet) {
        Officechairsize = officechairsize;
        Officedesksize = officedesksize;
        Meetingtablesize = meetingtablesize;
        Bookcasesize = bookcasesize;
        Officecabinet = officecabinet;
    }
    public Databases(){
        Officechairsize=0;
        Officedesksize=0;
        Meetingtablesize=0;
        Bookcasesize=0;
        Officecabinet=0;
    }

    public void incrementfunction(furniture temp){

            if (temp.getName().equals("Office Chair")) {
                this.incoffichair();
            }
            else if (temp.getName().equals("Office Desk")) {
                 this.incoffidesk();
            }

            else if (temp.getName().equals("Bookcase")) {
                this.incbookcase();
            }

           else if (temp.getName().equals("Office Cabinet")) {
            this.incofficabinet();
           }

            else if (temp.getName().equals("Meeting Table")) {
                this.incmeetingtable();
            }
            else{
                System.out.println("False Furniture Add");
            }
        }

    public void decrementfunction(furniture temp){
        if (temp.getName().equals("Office Chair")) {
            this.decoffichair();
        }
        else if (temp.getName().equals("Office Desk")) {
            this.decoffidesk();
        }

        else if (temp.getName().equals("Bookcase")) {
            this.decbookcase();
        }

        else if (temp.getName().equals("Office Cabinet")) {
            this.decofficabinet();
        }

        else if (temp.getName().equals("Meeting Table")) {
            this.decmeetingtable();
        }
        else{
            System.out.println("False Furniture Add");
        }

    }

    public int getOfficechairsize() {
        return Officechairsize;
    }

    public void setOfficechairsize(int officechairsize) {
        Officechairsize = officechairsize;
    }

    public int getOfficedesksize() {
        return Officedesksize;
    }

    public void setOfficedesksize(int officedesksize) {
        Officedesksize = officedesksize;
    }

    public int getMeetingtablesize() {
        return Meetingtablesize;
    }

    public void setMeetingtablesize(int meetingtablesize) {
        Meetingtablesize = meetingtablesize;
    }

    public int getBookcasesize() {
        return Bookcasesize;
    }

    public void setBookcasesize(int bookcasesize) {
        Bookcasesize = bookcasesize;
    }

    public int getOfficecabinet() {
        return Officecabinet;
    }

    public void setOfficecabinet(int officecabinet) {
        Officecabinet = officecabinet;
    }

    public void incoffichair(){
        this.Officechairsize=this.Officechairsize+1;
    }
    public void decoffichair(){
        this.Officechairsize=this.Officechairsize-1;
    }

    public void incoffidesk(){
        this.Officedesksize=this.Officedesksize+1;
    }
    public void decoffidesk(){
        this.Officedesksize=this.Officedesksize-1;
    }

    public void incmeetingtable(){
        this.Meetingtablesize= this.Meetingtablesize+1;
    }
    public void decmeetingtable(){
        this.Meetingtablesize= this.Meetingtablesize-1;
    }

    public void incbookcase(){
        this.Bookcasesize=this.Bookcasesize+1;
    }
    public void decbookcase(){
        this.Bookcasesize=this.Bookcasesize-1;
    }

    public void incofficabinet(){
        this.Officecabinet= this.Officecabinet+1;
    }
    public void decofficabinet(){
        this.Officecabinet= this.Officecabinet-1;
    }
}
