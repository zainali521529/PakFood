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

import com.example.pakfodies.databinding.FragmentFoodBinding;
import com.example.pakfodies.databinding.FragmentHomeBinding;


public class FoodFragment extends Fragment {


    private FragmentFoodBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding=FragmentFoodBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    mBinding.intentSearch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            NavController controller= Navigation.findNavController(view);
            controller.navigate(R.id.action_foodFragment_to_searchFragment);
            Toast.makeText(getContext(),"Go to Search Fragment",Toast.LENGTH_LONG).show();
        }
    });
    }
}