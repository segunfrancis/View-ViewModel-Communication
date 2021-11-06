# View-ViewModel-Communication
A simple project that describes the relationship between the view and it's viewmodel in android development

In MVVM architecture, this sample project describes how the `View` layer shouldn't directly alter its views. Developers have the tendency of altering the state of their views directly from the `View` layer, this has a tendency of causing bugs and making scalability difficult.

This approach shows how the `ViewModel` carries the responsibility of handling the state of the views. The views send actions to the viewModel which in turn alter the state of the views. The state also include a `Warning` state that is triggered when the minimum or maximum numbers are reached.

Another advantage of this approach is that the state of the views are maintained during configuration change, this prevents the step of retaining state using things like `savedInstanceState`.

### Screenshots
<p align="middle">
 <img src="https://github.com/segunfrancis/View-ViewModel-Communication/blob/master/screenshot/Screenshot_20211106_001356.png" alt="screenshot 1" width="33%">
 <img src="https://github.com/segunfrancis/View-ViewModel-Communication/blob/master/screenshot/Screenshot_20211106_001449.png" alt="screenshot 2" width="33%">
 <img src="https://github.com/segunfrancis/View-ViewModel-Communication/blob/master/screenshot/Screenshot_20211106_001523.png" alt="screenshot 3" width="33%">
</p>
