package library.data;

public class SlideImpl implements Slide{
   private String slideText;
   private int slideId;
   private boolean question;

   public SlideImpl(String slideText, int slideId, boolean question) {
      this.slideText = slideText;
      this.slideId = slideId;
      this.question = question;
   }

   @Override
   public String getText() {
      return this.slideText;
   }

   @Override
   public void setText(String text) {
      this.slideText = text;
   }

   @Override
   public int getSlideId() {
      return this.slideId;
   }

   @Override
   public boolean isQuestion() {
      return this.question;
   }

   @Override
   public void setQuestion(boolean question) {
      this.question = question;
   }
}
