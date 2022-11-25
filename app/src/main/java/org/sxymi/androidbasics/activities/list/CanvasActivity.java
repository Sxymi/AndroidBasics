package org.sxymi.androidbasics.activities.list;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(new PlaystationCanvas(this));
    }

    private class PlaystationCanvas extends View {
        private Paint strokePaint;
        private float centerX;
        private float centerY;
        private float shapeSize;
        private float halfShapeSize;
        private float margin;
        private float halfMargin;

        public PlaystationCanvas(Context context) {
            super(context);
            this.initializeStrokePaint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.centerX = (float) this.getWidth() / 2;
            this.centerY = (float) this.getHeight() / 2;
            this.shapeSize = 200;
            this.halfShapeSize = this.shapeSize / 2;
            this.margin = 10 + (this.strokePaint.getStrokeWidth() / 2);
            this.halfMargin = this.margin / 2;

            this.drawBackground(canvas);
            this.drawSquare(canvas);
            this.drawTriangle(canvas);
            this.drawCircle(canvas);
            this.drawX(canvas);
        }

        private void initializeStrokePaint() {
            this.strokePaint = new Paint();
            this.strokePaint.setColor(Color.WHITE);
            this.strokePaint.setStyle(Paint.Style.STROKE);
            this.strokePaint.setStrokeWidth(20);
        }

        private void setStrokePaintColor(int color) {
            this.strokePaint.setColor(color);
        }

        private void drawBackground(Canvas canvas) {
            Paint paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.FILL);

            canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
        }

        private void drawSquare(Canvas canvas) {
            this.setStrokePaintColor(Color.rgb(208, 123, 182));
            float topLeftX = this.centerX - (this.margin * 2) - this.halfMargin - (this.shapeSize * 2);
            float topLeftY = this.centerY - this.halfShapeSize;
            canvas.drawRect(topLeftX, topLeftY, topLeftX + this.shapeSize, topLeftY + this.shapeSize, this.strokePaint);
        }

        private void drawTriangle(Canvas canvas) {
            this.setStrokePaintColor(Color.rgb(25, 179, 145));
            float xBase = this.centerX - this.halfMargin;
            float yBase = this.centerY + this.halfShapeSize;
            Point a = this.createPoint(xBase - this.shapeSize, yBase);
            Point b = this.createPoint(xBase, yBase);
            Point c = this.createPoint(xBase - this.halfShapeSize, this.centerY - this.halfShapeSize);

            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.setLastPoint(a.x, a.y);
            path.lineTo(b.x, b.y);
            path.lineTo(c.x, c.y);
            path.lineTo(a.x, a.y);
            path.close();

            canvas.drawPath(path, this.strokePaint);
        }

        private void drawCircle(Canvas canvas) {
            this.setStrokePaintColor(Color.rgb(239, 98, 97));
            float xCircle = this.centerX + this.halfMargin + this.halfShapeSize;
            canvas.drawCircle(xCircle, this.centerY, this.halfShapeSize, this.strokePaint);
        }

        private void drawX(Canvas canvas) {
            this.setStrokePaintColor(Color.rgb(141, 150, 199));
            float xCenter = this.centerX + this.halfMargin + (this.margin * 2) + this.shapeSize + this.halfShapeSize;
            float xLeft = xCenter - this.halfShapeSize;
            float xRight = xCenter + this.halfShapeSize;
            float yTop = this.centerY - this.halfShapeSize;
            float yBottom = this.centerY + this.halfShapeSize;

            Point a = this.createPoint(xLeft, yTop);
            Point b = this.createPoint(xRight, yTop);
            Point c = this.createPoint(xLeft, yBottom);
            Point d = this.createPoint(xRight, yBottom);

            canvas.drawLine(a.x, a.y, d.x, d.y, this.strokePaint);
            canvas.drawLine(b.x, b.y, c.x, c.y, this.strokePaint);
        }

        private Point createPoint(float x, float y) {
            return new Point(Math.round(x), Math.round(y));
        }
    }
}
