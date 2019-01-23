package org.onaio.rxgithub.presentation.ui.main

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import de.hdodenhof.circleimageview.CircleImageView
import org.onaio.rxgithub.R
import org.onaio.rxgithub.domain.entities.GithubUser
import org.onaio.rxgithub.presentation.utils.CommonUtils

class UserDetailsFragment : BottomSheetDialogFragment() {
    private lateinit var name: TextView
    private lateinit var bio: TextView
    private lateinit var location: TextView
    private lateinit var company: TextView
    private lateinit var repos: TextView
    private lateinit var followers: TextView
    private lateinit var following: TextView
    private lateinit var profile: CircleImageView

    private fun bindViews(currentView: View?) {
        currentView?.run {
            name = currentView.findViewById(R.id.fullName)
            bio = currentView.findViewById(R.id.bioTextview)
            location = currentView.findViewById(R.id.locationTextView)
            company = currentView.findViewById(R.id.companyTextView)
            repos = currentView.findViewById(R.id.reposTextView)
            followers = currentView.findViewById(R.id.followersTextView)
            following = currentView.findViewById(R.id.followingTextView)
            profile = currentView.findViewById(R.id.githubProfileImageView)
        }

    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(requireContext(), theme)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val currentView = inflater.inflate(R.layout.user_details_fragment, container, false)
        bindViews(currentView)
        handleArgs()
        return currentView
    }


    private fun handleArgs() {
        val username = arguments?.getString("USERNAME")
        val githubUser = GithubUser(username = username)
        githubUser.let {
            it.fullName = arguments?.getString("NAME") ?: "(No name)"
            it.bio = arguments?.getString("BIO") ?: "(Not specified)"
            it.location = arguments?.getString("LOCATION") ?: "(Not specified)"
            it.company = arguments?.getString("COMPANY") ?: "(Not specified)"
            it.publicRepos = arguments?.getString("REPOS") ?: "(N/A)"
            it.followers = arguments?.getString("FOLLOWERS") ?: "(N/A)"
            it.following = arguments?.getString("FOLLOWING") ?: "(N/A)"
            it.imageUri = arguments?.getString("PROFILE")
        }

        displayUserDetails(githubUser)
    }

    private fun displayUserDetails(githubUser: GithubUser) {
        name.text = githubUser.fullName
        company.text = githubUser.company
        followers.text = githubUser.followers
        following.text = githubUser.following
        repos.text = githubUser.publicRepos
        location.text = githubUser.location
        bio.text = githubUser.bio
        CommonUtils.loadImage(githubUser.imageUri, profile)
    }


}