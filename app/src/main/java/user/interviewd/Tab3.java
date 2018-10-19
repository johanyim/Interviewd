package user.interviewd;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View v;



    private OnFragmentInteractionListener mListener;

    public Tab3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab3.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab3 newInstance(String param1, String param2) {
        Tab3 fragment = new Tab3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(user.interviewd.R.layout.fragment_tab3, container, false);

        setupAll(v);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for info information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setupAll(View v){
        setupTitleAndBody(v);
    }


    private void setupTitleAndBody(View v){
        String[] titles = getResources().getStringArray(user.interviewd.R.array.info_title_text_array);
        String[] bodies = getResources().getStringArray(user.interviewd.R.array.info_body_text_array);

//        TextView[] TitleThenBodyArray = new TextView[2*noOfTitleAndBodies];
        TextView temp;

        for (int i = 0; i < Math.max(titles.length, bodies.length); i++)
        {
            LinearLayout linearLayout = (LinearLayout) v.findViewById(user.interviewd.R.id.infoPageLinearLayout);

            //Handling title text

            temp = new TextView(getContext());
            try{
                temp.setText(titles[i]);
            }catch(ArrayIndexOutOfBoundsException e){
                temp.setText("[Missing Title]");
            }

            Linkify.addLinks(temp, Linkify.ALL);
            temp.setLinksClickable(true);

            temp.setTextColor(getResources().getColor(user.interviewd.R.color.infoTitleTextColor));
            temp.setTextSize(pixelsToSp(getResources().getDimension(user.interviewd.R.dimen.info_title_text_size)));
            linearLayout.addView(temp);

            //Handling body text

            temp = new TextView(getContext());
            try{
                temp.setText("\n" + bodies[i] + "\n\n");
            }catch(ArrayIndexOutOfBoundsException e){
                temp.setText("[Missing body]");
            }

            Linkify.addLinks(temp, Linkify.ALL);
            temp.setLinksClickable(true);

            temp.setTextColor(getResources().getColor(user.interviewd.R.color.infoBodyTextColor));
            temp.setTextSize(pixelsToSp(getResources().getDimension(user.interviewd.R.dimen.info_body_text_size)));
            linearLayout.addView(temp);

        }
    }

    private float pixelsToSp(float px)
    {
        float scaledDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
        return px/scaledDensity;
    }//for setting the text size using values from the dimens.xml

}
