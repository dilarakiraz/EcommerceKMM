import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.dilarakiraz.composempnotes.presentation.ui.home.HomeScreen
import org.dilarakiraz.composempnotes.presentation.viewmodel.HomeViewModel

@Composable
fun App() {
    MaterialTheme {
        HomeScreen(
            homeViewModel = HomeViewModel(),
        )
    }
}