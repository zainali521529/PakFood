package com.example.pakfodies;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pakfodies.databinding.FragmentNotificationBinding;

public class NotificationFragment extends Fragment {
    private FragmentNotificationBinding mBingding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       mBingding=FragmentNotificationBinding.inflate(inflater,container,false);
       return mBingding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBingding.intentFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller= Navigation.findNavController(view);
                controller.navigate(R.id.action_notificationFragment_to_foodFragment);
                Toast.makeText(getContext(),"Go to Food Fragment",Toast.LENGTH_LONG).show();
            }
        });
    }
}