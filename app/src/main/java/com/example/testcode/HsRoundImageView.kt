package com.example.testcode

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * <pre>
 *     author : zhaoyx
 *     time   : 2023/7/31 9:03
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class HsRoundImageView : AppCompatImageView {


    private var leftTopRadius: Int = 0;
    private var rightTopRadius: Int = 0;
    private var leftBottomRadius: Int = 0;
    private var rightBottomRadius: Int = 0;
    private var allRadius: Int = 0;


    constructor(context: Context) : super(context) {

        initAtter(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initAtter(context, attrs)
    }

    private fun initAtter(context: Context?, attrs: AttributeSet?) {
        val typed = context?.obtainStyledAttributes(attrs, R.styleable.roundRadion);

        if (typed == null)
            return;


        leftTopRadius = typed.getInt(R.styleable.roundRadion_mleftTopRadius, 0);
        rightTopRadius = typed.getInt(R.styleable.roundRadion_mrightRadius, 0);
        leftBottomRadius = typed.getInt(R.styleable.roundRadion_mleftButtomRadius, 0);
        rightBottomRadius = typed.getInt(R.styleable.roundRadion_mrightButtomRadius, 0);
        allRadius = typed.getInt(R.styleable.roundRadion_allRadius, 0);


        typed.recycle();
    }

    override fun onDraw(canvas: Canvas?) {


        val width = getMeasuredWidth();
        val height = getMeasuredHeight();
        var path = Path();
        /*向路径中添加圆角矩形。radii数组定义圆角矩形的四个圆角的x,y半径。radii长度必须为8*/

        if (allRadius > 0) {
            var rids: FloatArray = floatArrayOf(
                toFloat(allRadius),
                toFloat(allRadius),
                toFloat(allRadius),
                toFloat(allRadius),
                toFloat(allRadius),
                toFloat(allRadius),
                toFloat(allRadius),
                toFloat(allRadius)
            )
            path.addRoundRect(
                RectF(0f, 0f, width.toFloat(), height.toFloat()),
                rids,
                Path.Direction.CW
            );

        } else {
            var rids = floatArrayOf(
                toFloat(leftTopRadius),
                toFloat(leftTopRadius),
                toFloat(rightTopRadius),
                toFloat(rightTopRadius),
                toFloat(leftBottomRadius),
                toFloat(leftBottomRadius),
                toFloat(rightBottomRadius),
                toFloat(rightBottomRadius)
            )

            path.addRoundRect(
                RectF(0f, 0f, width.toFloat(), height.toFloat()),
                rids,
                Path.Direction.CW
            );
        }
        canvas?.clipPath(path);
        super.onDraw(canvas)

    }


    private fun toFloat(value: Int): Float = value.toFloat()

    fun setAllRadius(allRadius: Int) {
        this.allRadius = allRadius
        invalidate()
    }

    fun setLeftTopRadius(value: Int) {
        leftTopRadius = value;
        allRadius = 0;
        invalidate()
    }


    fun setRightTopRadius(value: Int) {
        rightTopRadius = value;
        allRadius = 0;
        invalidate()
    }


    fun setLeftbottomRadius(value: Int) {
        leftBottomRadius = value;
        allRadius = 0;
        invalidate()
    }

    fun setRightebottomRadius(value: Int) {
        rightTopRadius = value;
        allRadius = 0;
        invalidate()
    }

}