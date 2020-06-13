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

import com.example.pakfodies.databinding.FragmentSearchBinding;


public class SearchFragment extends Fragment {

   private FragmentSearchBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding=FragmentSearchBinding.inflate(inflater,container,false);
        return mBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.intentHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller= Navigation.findNavController(view);
                controller.navigate(R.id.action_searchFragment_to_homeFragment);
                Toast.makeText(getContext(),"Go to Home Fragment",Toast.LENGTH_LONG).show();
            }
        });
    }
}