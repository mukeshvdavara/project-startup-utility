
class BaseAdapter<T : Any>(
    private val context: Context,
    @LayoutRes private val layoutRes: Int,
    private val callback: (T, RecyclerView.ViewHolder) -> Unit
) : ListAdapter<T, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = Objects.equal(oldItem, newItem)

    override fun areContentsTheSame(oldItem: T, newItem: T) = Objects.equal(oldItem, newItem)

}) {

    companion object {
        fun <T : Any> create(
            context: Context,
            @LayoutRes layoutRes: Int,
            callback: (item: T, holder: RecyclerView.ViewHolder) -> Unit
        ): BaseAdapter<T> {
            return BaseAdapter(context, layoutRes, callback)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(layoutRes, parent, false)
        return object : RecyclerView.ViewHolder(view) {
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        callback.invoke(item, holder)
    }
}
