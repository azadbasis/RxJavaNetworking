package com.me.rxjavanetworking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.annotations.Nullable;

class GitHubRepoAdapter extends RecyclerView.Adapter<GitHubRepoAdapter.GitHubRepoViewHolder> {

    private List<GitHubRepo> gitHubRepos = new ArrayList<>();


    @NonNull
    @Override
    public GitHubRepoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_github_repo, parent, false);
        return new GitHubRepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubRepoViewHolder holder, int position) {
        holder.setGitHubRepo(gitHubRepos.get(position));

    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return gitHubRepos.size();
    }


    public void setGitHubRepos(@Nullable List<GitHubRepo> repos) {
        if (repos == null) {
            return;
        }
        gitHubRepos.clear();
        gitHubRepos.addAll(repos);
        notifyDataSetChanged();
    }
    public static class GitHubRepoViewHolder  extends RecyclerView.ViewHolder{

        private TextView textRepoName;
        private TextView textRepoDescription;
        private TextView textLanguage;
        private TextView textStars;

        public GitHubRepoViewHolder(View view) {
            super(view);
            textRepoName = (TextView) view.findViewById(R.id.text_repo_name);
            textRepoDescription = (TextView) view.findViewById(R.id.text_repo_description);
            textLanguage = (TextView) view.findViewById(R.id.text_language);
            textStars = (TextView) view.findViewById(R.id.text_stars);
        }

        public void setGitHubRepo(GitHubRepo gitHubRepo) {
            textRepoName.setText(gitHubRepo.name);
            textRepoDescription.setText(gitHubRepo.description);
            textLanguage.setText("Language: " + gitHubRepo.language);
            textStars.setText("Stars: " + gitHubRepo.stargazersCount);
        }
    }
}
