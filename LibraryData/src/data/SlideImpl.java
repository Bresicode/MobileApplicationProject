package data;

public class SlideImpl implements Slide{
   private String slideText;
   private int slideId;
   private boolean isQuestion;

   @Override
   public String getText() {
      return null;
   }

   @Override
   public void setText(String text) {

   }

   @Override
   public int getSlideId() {
      return 0;
   }

   @Override
   public boolean isQuestion() {
      return false;
   }

   @Override
   public void setQuestion(boolean question) {

   }
}
