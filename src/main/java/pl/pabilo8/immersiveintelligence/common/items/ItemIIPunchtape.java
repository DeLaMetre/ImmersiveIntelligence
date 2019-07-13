package pl.pabilo8.immersiveintelligence.common.items;

import blusunrize.immersiveengineering.common.util.ItemNBTHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import pl.pabilo8.immersiveintelligence.api.data.DataHelper;
import pl.pabilo8.immersiveintelligence.api.data.DataPacket;
import pl.pabilo8.immersiveintelligence.api.data.IDataStorageItem;

/**
 * Created by Pabilo8 on 25-06-2019.
 */
public class ItemIIPunchtape extends ItemIIBase implements IDataStorageItem
{
	public ItemIIPunchtape()
	{
		super("punchtape", 8);
	}

	@Override
	public DataPacket getStoredData(ItemStack stack)
	{
		NBTTagCompound tag = stack.serializeNBT();
		NBTTagCompound realtag = ItemNBTHelper.getTagCompound(stack, "stored_data");
		DataPacket data = new DataPacket();
		data.fromNBT(realtag);
		return data;
	}

	@Override
	public void writeDataToItem(DataPacket packet, ItemStack stack)
	{
		ItemNBTHelper.setTagCompound(stack, "stored_data", packet.toNBT());
	}

	@Override
	public String getDataStorageItemType(ItemStack stack)
	{
		return DataHelper.DATA_STORAGE_TYPE_PUNCHCTAPE;
	}
}