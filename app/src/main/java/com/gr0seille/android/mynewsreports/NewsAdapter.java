package com.gr0seille.android.mynewsreports;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class NewsAdapter extends ArrayAdapter<News> {


    public NewsAdapter(Context context, List<News> earthquakes) {
        super(context, 0, earthquakes);
    }

    /**
     * Returns a list item view that displays the news
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

        News currentNews = getItem(position);

        // Find the TextView with their id and display them. Here its for the title
        TextView titleView = (TextView) listItemView.findViewById(R.id.web_title);
        titleView.setText(currentNews.getWebTitle());

        // for the section category
        TextView sectionName = (TextView) listItemView.findViewById(R.id.section_name);
        sectionName.setText(currentNews.getSectionName());

        //For the date...
        TextView dateView = (TextView) listItemView.findViewById(R.id.web_publication_date);

        // ...we take as input a String formatted as such "2010-10-15T09:27:37Z" and we turn it to a date
        String string = currentNews.getWebPublicationDate();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        Date dater = null;
        try {
            dater = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dater);


        //then we format it to a nicer date and push it back as a string
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm", Locale.ENGLISH);
        String dateString = sdf.format(dater);
        dateView.setText(dateString);

        return listItemView;
    }

}

