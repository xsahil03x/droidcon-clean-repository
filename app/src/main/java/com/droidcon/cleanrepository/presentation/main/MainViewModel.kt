package com.droidcon.cleanrepository.presentation.main

import com.droidcon.service.GithubService
import com.droidcon.service.TwitterService
import com.droidcon.cleanrepository.presentation.LifecycleViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(
    var githubService: GithubService,
    var twitterService: TwitterService
) : LifecycleViewModel()
