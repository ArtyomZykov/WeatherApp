package forest.zykov.weatherapp

class LiveEvent : SingleLiveEvent<Unit>() {
    operator fun invoke() {
        this.value = Unit
    }
}