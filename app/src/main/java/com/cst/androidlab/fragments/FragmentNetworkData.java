package com.cst.androidlab.fragments;

import static com.cst.androidlab.helpers.Constants.BASE_URL;
import static com.cst.androidlab.helpers.Constants.BODY;
import static com.cst.androidlab.helpers.Constants.POSTS_ENDPOINT;
import static com.cst.androidlab.helpers.Constants.TITLE;
import static com.cst.androidlab.helpers.Constants.USER_ID;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.cst.androidlab.R;
import com.cst.androidlab.adapters.UserPostsAdapter;
import com.cst.androidlab.helpers.VolleyConfigSingleton;
import com.cst.androidlab.models.UserPostItemModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentNetworkData extends Fragment {

   private SwipeRefreshLayout swipeRefreshLayout;
   private TextView dataInstructionsTextView;

   private final ArrayList<UserPostItemModel> userPosts = new ArrayList<>();
   private final UserPostsAdapter adapter = new UserPostsAdapter(userPosts);

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_network_data, container, false);

      return view;
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);

      dataInstructionsTextView = view.findViewById(R.id.tv_data_instructions);
      setDataInstructionsVisibility();

      setupRecyclerView(view);
      setupSwipeRefreshLayout(view);
   }

   private void setupSwipeRefreshLayout(@NonNull View view) {
      swipeRefreshLayout = view.findViewById(R.id.srl_list);
      swipeRefreshLayout.setOnRefreshListener(() -> {
         getPosts();
      });
   }

   private void setupRecyclerView(@NonNull View view) {
      RecyclerView recyclerView = view.findViewById(R.id.rv_movies);
      recyclerView.setAdapter(adapter);

      LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
      recyclerView.setLayoutManager(layoutManager);
   }

   private void getPosts() {
      VolleyConfigSingleton volleyConfigSingleton = VolleyConfigSingleton.getInstance(getContext());
      RequestQueue queue = volleyConfigSingleton.getRequestQueue();
      String url = BASE_URL + POSTS_ENDPOINT;

      StringRequest getPostsRequest = new StringRequest(
              Request.Method.GET,
              url,
              response -> {
                 try {
                    handlePostsResponse(response);
                 } catch (JSONException e) {
                    Toast.makeText(
                            getContext(),
                            "ERROR: get users failed with error:" + e,
                            Toast.LENGTH_SHORT
                    ).show();
                 }
                 hideLoading();
              },
              error -> {
                 Toast.makeText(
                         getContext(),
                         "ERROR: get users failed with error:" + error,
                         Toast.LENGTH_SHORT
                 ).show();
                 hideLoading();
              }
      );
      queue.add(getPostsRequest);
   }

   private void setDataInstructionsVisibility() {
      if(userPosts.isEmpty()) {
         dataInstructionsTextView.setVisibility(View.VISIBLE);
      } else {
         dataInstructionsTextView.setVisibility(View.GONE);
      }
   }

   private void handlePostsResponse(String response) throws JSONException {
      userPosts.clear();

      JSONArray postsJSONArray = new JSONArray(response);
      for(int index = 0; index < postsJSONArray.length(); index++) {
         JSONObject userPostJson = (JSONObject) postsJSONArray.get(index);
         if(userPostJson != null) {
            int userId = userPostJson.getInt(USER_ID);
            String body = userPostJson.getString(BODY);
            String title = userPostJson.getString(TITLE);

            UserPostItemModel model = new UserPostItemModel(userId, title, body);
            userPosts.add(model);
         }
      }

      adapter.notifyItemRangeChanged(0, userPosts.size());
   }

   private void hideLoading() {
      swipeRefreshLayout.setRefreshing(false);
      setDataInstructionsVisibility();
   }
}
