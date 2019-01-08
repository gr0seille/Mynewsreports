package com.gr0seille.android.mynewsreports;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * The part of the location string from the USGS service that we use to determine
     * whether or not there is a location offset present ("5km N of Cairo, Egypt").
     */
    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param earthquakes is the list of earthquakes, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the earthquake at the given position in the list of earthquakes
        News currentEarthquake = getItem(position);

        // Find the TextView with view ID web_title and display the effective text in the view
        TextView titleView = (TextView) listItemView.findViewById(R.id.web_title);
        titleView.setText(currentEarthquake.getWebTitle());

        // Find the TextView with view ID section name
        TextView sectionName = (TextView) listItemView.findViewById(R.id.section_name);
        // Display the location of the current earthquake in that TextView
        sectionName.setText(currentEarthquake.getSectionName());

        // Create a new Date object from the time in milliseconds of the earthquake
       // Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.web_publication_date);
        // Format the date string (i.e. "Mar 3, 1984")
        //String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        //dateView.setText(formattedDate);
        dateView.setText(currentEarthquake.getWebPublicationDate());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

//    /**
//     * Return the color for the magnitude circle based on the intensity of the earthquake.
//     *
//     * @param magnitude of the earthquake
//     */
//    private int getMagnitudeColor(double magnitude) {
//        int magnitudeColorResourceId;
//        int magnitudeFloor = (int) Math.floor(magnitude);
//        switch (magnitudeFloor) {
//            case 0:
//            case 1:
//                magnitudeColorResourceId = R.color.magnitude1;
//                break;
//            case 2:
//                magnitudeColorResourceId = R.color.magnitude2;
//                break;
//            case 3:
//                magnitudeColorResourceId = R.color.magnitude3;
//                break;
//            case 4:
//                magnitudeColorResourceId = R.color.magnitude4;
//                break;
//            case 5:
//                magnitudeColorResourceId = R.color.magnitude5;
//                break;
//            case 6:
//                magnitudeColorResourceId = R.color.magnitude6;
//                break;
//            case 7:
//                magnitudeColorResourceId = R.color.magnitude7;
//                break;
//            case 8:
//                magnitudeColorResourceId = R.color.magnitude8;
//                break;
//            case 9:
//                magnitudeColorResourceId = R.color.magnitude9;
//                break;
//            default:
//                magnitudeColorResourceId = R.color.magnitude10plus;
//                break;
//        }
//
//        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
//    }

//    /**
//     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
//     * from a decimal magnitude value.
//     */
//    private String formatMagnitude(double magnitude) {
//        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
//        return magnitudeFormat.format(magnitude);
//    }
//
//    /**
//     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
//     */
//    private String formatDate(Date dateObject) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
//        return dateFormat.format(dateObject);
//    }
//
//    /**
//     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
//     */
//    private String formatTime(Date dateObject) {
//        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
//        return timeFormat.format(dateObject);
//    }
}

