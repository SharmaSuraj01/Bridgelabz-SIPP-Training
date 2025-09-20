import java.util.*;

public class Bookbuddy {
    ArrayList<String>books;
        Bookbuddy(){
            books=new ArrayList<>();
        }
        void addBook(String title,String author){
            books.add(title+"-"+author);
        }
        void sortBook(){
            for(int i=0;i<books.size()-1;i++){
                for(int j=0;j<books.size()-i-1;j++){
                    String title1=books.get(j).split("-")[0];
                    String title2=books.get(j+1).split("-")[0];
                    if(title1.compareToIgnoreCase(title2)>0){
                        String temp=books.get(j);
                        books.set(j, books.get(j+1));
                        books.set(j+1,temp);
                    }
                }
            }
        }
        ArrayList<String> search(String author){
            ArrayList<String>ans=new ArrayList<>();
            for(String book:books){
                String[] temp=book.split("-");
                if(temp.length>1&&temp[1].equals(author)){
                    ans.add(book);

                }
            }
            return ans;
        }
        public String[] export(){
            return books.toArray(new String[0]);

        }
        void displayBook(){
            for(String book:books){
                System.out.println(book);
            }
        }

    public static void main(String[] args) {
        Bookbuddy buddy=new Bookbuddy();
        buddy.addBook("let us c","James Gosling");
        buddy.addBook("mahabhart","maharshi vedvyas");
        buddy.addBook("indian","uttam kumar");
//        buddy.sortBook();
        buddy.displayBook();

    }

}
