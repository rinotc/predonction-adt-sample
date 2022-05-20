package sample2

sealed trait ValidationState

sealed trait Valid extends ValidationState

sealed trait NotValid extends ValidationState
