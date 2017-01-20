package com.maxmedia.madisonmiller.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.ColorRes;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * Created by joshua on 2/3/16.
 */
public class MyUtils {
	@SafeVarargs public static <T> ArrayList<T> asList (T... array) {
		ArrayList<T> arrayList = new ArrayList<>(array.length);
		Collections.addAll(arrayList, array);
		return arrayList;
	}

	public static float avg (Float... numbers) {
		if (numbers.length == 0) { return 0; }
		float sum = 0;
		for (float x : numbers) sum += x;
		return sum / numbers.length;
	}

	public static void delayRunnable (final long millsToDelay, final Runnable runnableToRun) {
		new Thread(() -> {
			try {
				Thread.sleep(millsToDelay);
			} catch (InterruptedException ignored) { }
			runnableToRun.run();
		}).start();
	}

	public static void delayRunnableOnUI (final long millsToDelay, final Runnable runnableToRun) {
		new Thread(() -> {
			try {
				Thread.sleep(millsToDelay);
			} catch (InterruptedException ignored) { }
			new Handler(Looper.getMainLooper()).post(runnableToRun);
		}).start();
	}

	public static Point findCenterOf (View v) {
		return findCenterOf(new Point(v.getWidth(), v.getHeight()));
	}

	public static Point findCenterOf (Point point) {
		return new Point(point.x / 2, point.y / 2);
	}

	public static String formatPlural (String s, int n) {
		return String.format(s.replace("(s)", Math.abs(n) == 1 ? "" : "s"), n);
	}

	public static int getColor (Context context, @ColorRes int color_resource) {
		return getColor(context, color_resource, context.getTheme());
	}

	public static int getColor (Context context, @ColorRes int color_resource, Resources.Theme theme) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { return context.getResources().getColor(color_resource, theme); }
		else { return context.getResources().getColor(color_resource); }
	}

	private static float getEffectiveDiff (float mainFloat, float secondaryFloat) {
		float avg = MyUtils.avg(mainFloat, secondaryFloat);
		if (avg > mainFloat) { avg = mainFloat - (avg - mainFloat); }
		return avg / mainFloat;
	}

	private static ViewGroup.LayoutParams getLayoutParamsMatchParent (View view) {
		ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
		layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
		layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
		return layoutParams;
	}

	public static String getOrdinal (int n) {
		String[] ordinals = { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };

		int ordinalIndex = Math.abs(n);
		if (ordinalIndex > 9 && ordinalIndex < 20) {
			ordinalIndex = 0;
		}
		else {
			while (ordinalIndex > ordinals.length - 1) {
				ordinalIndex -= 10;
			}
		}
		return String.format(Locale.getDefault(), "%d%s", n, ordinals[ordinalIndex]);
	}

	public static int getScreenHeight (Context context) {
		return getScreenSize(context).y;
	}

	public static DisplayMetrics getScreenMetrics (Context context) {
		DisplayMetrics metrics = new DisplayMetrics();
		WindowManager  wm      = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(metrics);
		return metrics;
	}

	public static Point getScreenSize (Context context) {
		DisplayMetrics metrics = getScreenMetrics(context);
		return new Point(metrics.widthPixels, metrics.heightPixels);
	}

	public static int getScreenWidth (Context context) {
		return getScreenSize(context).x;
	}

	public static boolean isWithinTolerance (float mainFloat, float secondaryFloat, double tolerance) {
		return getEffectiveDiff(mainFloat, secondaryFloat) > tolerance;
	}

	public static double round (double d, int digits) {
		double magnitudeOf10 = Math.pow(10, digits);
		return Math.round(d * magnitudeOf10) / magnitudeOf10;
	}

	public static void runOnUI (Runnable runnable) {
		delayRunnableOnUI(0, runnable);
	}

	public static void setLayoutParamsMatchParent (View view) {
		view.setLayoutParams(getLayoutParamsMatchParent(view));
	}

	public static void setLayoutParamsMatchParentHeight (View view) {
		ViewGroup.LayoutParams layoutParams = getLayoutParamsMatchParent(view);
		layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
		view.setLayoutParams(layoutParams);
	}

	public static void setLayoutParamsMatchParentWidth (View view) {
		ViewGroup.LayoutParams layoutParams = getLayoutParamsMatchParent(view);
		layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
		view.setLayoutParams(layoutParams);
	}

	public static void setLayoutParamsWrapContent (View view) {
		ViewGroup.LayoutParams layoutParams = getLayoutParamsMatchParent(view);
		layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
		layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
		view.setLayoutParams(layoutParams);
	}
}