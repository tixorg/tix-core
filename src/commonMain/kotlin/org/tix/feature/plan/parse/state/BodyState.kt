package org.tix.feature.plan.parse.state

import org.tix.model.ticket.body.BodySegment

internal class BodyState(body: MutableList<BodySegment>) : BodyBuilder {
    private val bodyStack = ArrayList<MutableList<BodySegment>>().also { it.add(body) }

    fun pushBody() = bodyStack.add(ArrayList())

    fun popBody() = bodyStack.removeLast()

    override fun addSegments(bodySegments: Array<out BodySegment>) {
        bodyStack.lastOrNull()?.addAll(bodySegments)
    }
}