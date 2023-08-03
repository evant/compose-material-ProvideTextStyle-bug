# Reproduction of an issue using ProvideTextStyle inside a SubcomposeLayout

expected: calls to `LocalTextStyle.current` remain stable
(assertion passes, app launches to a blank screen)
actual: `LocalTextStyle.current` gets reset after a call to a different `CompositionLocal`
(assertion fails and app crashes)

fails with material3 version `1.2.0-alpha04`, passes with version `1.1.1`.