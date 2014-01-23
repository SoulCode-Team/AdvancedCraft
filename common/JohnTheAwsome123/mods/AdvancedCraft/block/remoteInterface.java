package JohnTheAwsome123.mods.AdvancedCraft.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import JohnTheAwsome123.mods.AdvancedCraft.block.tileentity.TileEntityRemoteInterface;
import JohnTheAwsome123.mods.AdvancedCraft.lib.ACTextures;
import JohnTheAwsome123.mods.AdvancedCraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class remoteInterface extends BlockContainer {

	public remoteInterface(int par1)
	{
		this(par1, Material.rock);
	}

	public remoteInterface(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("remoteBlock");
		this.setCreativeTab(Reference.ACTAB);
		this.setHardness(3.0F);
		this.setStepSound(Block.soundStoneFootstep);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1registerIcon){
		this.blockIcon = par1registerIcon.registerIcon(ACTextures.GetTextureNameFull(this));
	}
	
	@Override
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityRemoteInterface();
    }
	
    private TileEntityRemoteInterface getTileEntity(IBlockAccess world, int x, int y, int z) {
        TileEntity te = world.getBlockTileEntity(x, y, z);
        if (te instanceof TileEntityRemoteInterface) {
            return (TileEntityRemoteInterface)te;
        }else{
            return null;
        }
    }
}
