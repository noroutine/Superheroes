package me.noroutine.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.noroutine.superheroes.model.Hero
import me.noroutine.superheroes.model.HeroesRepository
import me.noroutine.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroCard(hero: Hero, modifier: Modifier = Modifier) {
    ElevatedCard(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius)),
        elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.card_elevation)),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.card_padding))
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = dimensionResource(id = R.dimen.card_padding))
            ) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            HeroImage(imageResource = hero.imageRes, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun HeroImage(imageResource: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.image_clip_radius)))
    )
}

@Preview
@Composable
fun HeroCardPreview() {
    SuperheroesTheme {
        HeroCard(HeroesRepository.heroes[0])
    }
}

@Composable
fun HeroesScreen(modifier: Modifier = Modifier) {
    LazyColumn {
        items(HeroesRepository.heroes) {
            HeroCard(
                hero = it,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 16.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeroesScreenPreview() {
    SuperheroesTheme {
        HeroesScreen()
    }
}
