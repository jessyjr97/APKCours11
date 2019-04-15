package cours11.exeinformatique.com.cours11;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

public class PlanView extends View {
    private float zoomLevel = 1f;
    private float currX = 0;
    private float currY = 0;
    private List<PlanViewDisplayable> objectsToDisplay;

    public PlanView(Context context){
        super(context);
        Init(context, null);
    }
    public PlanView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        Init(context, attrs);
    }
    public PlanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        Init(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint myPaint = new Paint();
        myPaint.setTextSize(72);
        canvas.drawText("Test1", 10, 100, myPaint);
        canvas.save();
        DisplayObject(canvas);
        canvas.restore();
    }

    private void Init(Context context, AttributeSet set){
        objectsToDisplay = new LinkedList<>();
    }
    private void DisplayObject(Canvas canvas){
        for (PlanViewDisplayable objectToDisplay: objectsToDisplay){
            int positionImageX = (int) objectToDisplay.getPositionX();
            int positionImageY = (int) objectToDisplay.getPositionY();
            int imageToDisplayLeftPosition = 0;
            int imageToDisplayRightPosition = (int) objectToDisplay.getWidth();
            int imageToDisplayTopPosition = 0;
            int imageToDisplayBottomPosition = (int) objectToDisplay.getHeight();
            //////////////////////////////////////////////////////////////////////////
            int imageWhereToDisplayLeftPosition = (int) (positionImageX - currX);   //
            int imageWhereToDisplayRightPosition = imageWhereToDisplayLeftPosition  //
                        + imageToDisplayRightPosition - imageToDisplayLeftPosition; //
            int imageWhereToDisplayTopPosition = (int) (positionImageY + currY);    //
            int imageWhereToDisplayBottomPosition = imageWhereToDisplayTopPosition  //
                        + imageToDisplayBottomPosition - imageToDisplayTopPosition; //
            //////////////////////////////////////////////////////////////////////////
            canvas.drawBitmap(
                    objectToDisplay.getBitmap(),
                    new Rect(imageToDisplayLeftPosition, imageToDisplayTopPosition,
                            imageToDisplayRightPosition, imageToDisplayBottomPosition),
                    new Rect(imageWhereToDisplayLeftPosition, imageWhereToDisplayTopPosition,
                            imageWhereToDisplayRightPosition, imageWhereToDisplayBottomPosition),
                    null
            );
        }
    }
}
