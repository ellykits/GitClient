package org.onaio.rxgithub.presentation.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import org.onaio.rxgithub.R
import org.onaio.rxgithub.domain.entities.GithubUser
import org.onaio.rxgithub.presentation.utils.CommonUtils

class GithubUsersRecyclerAdapter :
    RecyclerView.Adapter<GithubUsersRecyclerAdapter.GithubUserViewHolder>() {

    private var listOfUsers: ArrayList<GithubUser> = arrayListOf()
    private lateinit var listener: View.OnClickListener

    fun setOnItemClickListener(onItemClickListener: View.OnClickListener) {
        this.listener = onItemClickListener
    }

    fun addUser(user: GithubUser) {
        listOfUsers.add(user)
        notifyDataSetChanged()
    }

    fun clearList() {
        listOfUsers.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubUserViewHolder {
        val profileSectionView = LayoutInflater.from(parent.context).inflate(
            R.layout.profile_section_layout,
            parent, false
        )
        return GithubUserViewHolder(profileSectionView)
    }

    override fun getItemCount(): Int {
        return listOfUsers.size
    }

    fun getGithubUser(pos: Int): GithubUser {
        return listOfUsers[pos]
    }

    override fun onBindViewHolder(holder: GithubUserViewHolder, position: Int) {
        val githubUser: GithubUser = listOfUsers[position]
        githubUser.also {
            holder.nameTextView?.text = it.fullName?.capitalize() ?: "(No name)"
            holder.usernameTextView?.text = holder.usernameTextView?.context?.getString(R.string.username, it.username)
            CommonUtils.loadImage(it.imageUri!!, holder.profileImage as ImageView)
            holder.removeButton?.setOnClickListener {
                listOfUsers.removeAt(position)
                notifyDataSetChanged()
            }
        }
    }

    inner class GithubUserViewHolder(profileSection: View) : RecyclerView.ViewHolder(profileSection) {

        val profileImage = profileSection.findViewById<CircleImageView?>(R.id.githubProfileImageView)
        val usernameTextView = profileSection.findViewById<TextView?>(R.id.usernameTextView)
        val nameTextView = profileSection.findViewById<TextView?>(R.id.nameTextView)
        val removeButton = profileSection.findViewById<ImageButton?>(R.id.removeButton)

        init {
            profileSection.tag = this
            profileSection.setOnClickListener {
                listener.onClick(it)
            }
        }

    }

}