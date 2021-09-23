
import android.content.Context
import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/* Handles operations on MovementLiveData and holds details about it. */
class DataSource(resources: Resources,context: Context) {
    private val initialMovementList = MovementDatas(resources,context)
    private val movementLiveData = MutableLiveData(initialMovementList)

    /* Adds movement to liveData and posts value. */
    fun addMovement(movement: SampleData) {
        val currentList = movementLiveData.value
        if (currentList == null) {
            movementLiveData.postValue(listOf(movement))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, movement)
            movementLiveData.postValue(updatedList)
        }
    }

    /* Removes movement from liveData and posts value. */
    fun removeMovement(movement: SampleData) {
        val currentList = movementLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(movement)
            movementLiveData.postValue(updatedList)
        }
    }

    /* Returns movement given an ID. */
    fun getMovementForId(id: Long): SampleData? {
        movementLiveData.value?.let { movements ->
             movements.firstOrNull{ id == id}
        }
        return null
    }

    fun getMovementList(): LiveData<List<SampleData>> {
        return movementLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources,context: Context): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources,context)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}