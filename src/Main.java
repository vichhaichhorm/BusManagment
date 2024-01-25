public class Main {
   class person{
      private String name;
      private String address;
      person(String name, String address){
         this.address=address;
         this.name=name;
      }

   }
   class student extends person{
      private String course;
      private float score;
      int numberofcourse;
      student(String name,String addreess,int numberofcourse){
         super(name,addreess);
         this.numberofcourse=numberofcourse;

      }
      public void addcourse(String course, float score){
         this.course=course;
         this.score=score;
      }
   }
   public static void main(String[] args) {

   }
}
