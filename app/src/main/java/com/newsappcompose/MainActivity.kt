package com.newsappcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.newsappcompose.domain.models.News
import com.newsappcompose.ui.theme.NewsAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = hiltViewModel<MainViewModel>()
            NewsAppComposeTheme {
                MainScreen(viewModel = viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()))
        {
            MainList(news = viewModel.news)
        }
    }
}


@Composable
fun MainList(news: Flow<PagingData<News>>) {
    val lazyItems = news.collectAsLazyPagingItems()

    LazyColumn {
        items(lazyItems) { new ->
            Log.println(Log.ASSERT, "MAIM", new.toString())
            NewsItem(news = new!!)
        }
    }

}

@Composable
fun NewsItem(news: News) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(news.image)
                .crossfade(true)
                .placeholder(R.drawable.ic_launcher_foreground)
                .build(),
                contentDescription = null,
                modifier = Modifier.height(100.dp).width(200.dp)
            )
            Spacer(modifier = Modifier.size(2.dp))
            Text(text = news.title ?: "placeholder")
        }
    }
}

@Preview
@Composable
fun NewsItemPreview() {
    NewsAppComposeTheme() {
        NewsItem(
            news = News(
                author = "Ugwumadu Nnanta",
                title = "The Okowa gauntlet to Obi",
                description = "Obidients have quickly risen following Governor Ifeanyi Okowa’s challenge of the credentials of Mr. Peter Obi for governing at the highest levels. Some threw broadsides, and others went down the Rehash Lane of an assumed clean break with conventional politics. The fact of the matter is that Okowa’s challenge deserves interrogation to enrich our politics. [&#8230;]read more The Okowa gauntlet to Obi",
                url = "https://businessday.ng/opinion/article/the-okowa-gauntlet-to-obi/",
                source = "Businessday | News You Can Trust",
                image = null,
                category = "business",
                language = "en",
                country = "us",
                publishedAt = "2022-08-02T19:56:39+00:00",
            )
        )
    }
}