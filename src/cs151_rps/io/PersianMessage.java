package cs151_rps.io;

public class PersianMessage extends Message {

    public PersianMessage()
    {        
    }

    /**
     * Retrieve the localized string associated with the message ID
     * 
     * @param id message ID
     * @return localized string
     */
    @Override
    public String getMessage(ID id) {
        switch (id) {
            case RUN_USAGE:          return "استفاده: rps [-r <تعداد دور>]";
            case ROUND:              return "دور";
            case USER_PROMPT:        return "نوشتن 1 = سنگ 2 = کاغذ 3 = قیچی 4 کمک = 5 = نمره 6 = ترک:";
            case HELP:               return "قیچی می زند کاغذ. مقاله سنگ می زند. راک ضربان قیچی.";
            case SHOW_SCORE:         return "Score: ";
            case PROMPT_NAME:        return "نام خود را وارد کنینام و نام خانوادگی خود را بنویسید";
            case PROMPT_ROUNDS:      return "تعداد دفعاتی که شما می خواهید به بازی این بازی بنویسید";
            case INVALID_INPUT:      return "ورودی نادرست";
            case ROCK:               return "سنگ";
            case PAPER:              return "مقاله";
            case SCISSORS:           return "قیچی";
            case WELCOME:            return "بازی تیم قمری خوش آمدید.";
            case ROUND_WIN_ANNOUNCE: return " برنده!";
            case ROUND_WIN_REPORT:   return " برنده: ";
            case ROUND_TIE_ANNOUNCE: return "روابط";
            case ROUND_TIE_REPORT:   return "روابط: ";
            case QUIT_CONFIRM:       return "آیا شما مطمئن هستید که می خواهید برای ترک؟";
            case MATCH_WIN_ANNOUNCE: return " برنده بازی";
            case MATCH_TIE_ANNOUNCE: return "این مسابقه به پایان می رسد در یک کراوات!";
            case GESTURE_VERB:       return "حرکات";
            case SCORE_HEADER:       return "وضعیت";
            case QUIT:               return "ترک.برنامه خارج شده است."; 
            default: return "**را اجرا نکرده**";
        }
    }
    
}
